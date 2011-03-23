-- TODO: reikia trigerio, užtikrinančio, kad etape plaukianti jachta yra atitinkamos grupės dalyvė
-- TODO: reikai trigerio arba išorinio rakto, užtikrinančio, kad jachta regatoje dalyvauja tik vienoje grupėje

CREATE TABLE YachtClasses (
  id INTEGER IDENTITY,
  name VARCHAR(32) NOT NULL CHECK (length(trim(both from name)) > 0),
  coefficient FLOAT,
  projectYear INTEGER CHECK (projectYear BETWEEN 1500 AND EXTRACT(YEAR FROM CURRENT_DATE) + 1),
  length INTEGER CONSTRAINT lengthConstraint CHECK (length BETWEEN 100 AND 10000), -- centimetrais
  width INTEGER CONSTRAINT widthConstraint CHECK (width BETWEEN 50 AND 5000), -- centimetrais
  displacement INTEGER CHECK (displacement BETWEEN 10 AND 100000), -- kilogramais
  waterlineLength INTEGER CHECK (waterlineLength BETWEEN 100 AND 10000), -- centimetrais
  sailAreaDownwind INTEGER CHECK (sailAreaDownwind < 10000), -- kvadratiniais metrais
  sailAreaUpwind INTEGER CHECK (sailAreaUpwind < 10000), -- kvadratiniais metrais
  Notes VARCHAR(64)
  );
  
CREATE TABLE Yachts (
  id INTEGER IDENTITY,
  sailNumber VARCHAR(32) NOT NULL UNIQUE CHECK (length(trim(both from sailNumber)) > 0),
  yachtClass INTEGER NOT NULL REFERENCES YachtClasses,
  buildYear INTEGER CHECK (buildYear BETWEEN 1500 AND EXTRACT(YEAR FROM CURRENT_DATE) + 1),
  captain VARCHAR(64),
  owner VARCHAR(64),
  name VARCHAR(64) NOT NULL UNIQUE CHECK (length(trim(both from name)) > 0), -- FIXME: ar tinka UNIQUE?
  sponsors VARCHAR(64),
  notes VARCHAR(64)
  );
  
CREATE TABLE Regattas (
  id INTEGER IDENTITY,
  name VARCHAR(64) NOT NULL,
  region VARCHAR(64),
  begin DATE,
  end DATE,
  system TINYINT, -- FIXME: enum?
  notes VARCHAR(64)
  );
  
CREATE TABLE YachtGroups (
  id INTEGER IDENTITY,
  regatta INTEGER NOT NULL REFERENCES Regattas,
  name VARCHAR(32),
  notes VARCHAR(64)
  );
  
CREATE TABLE Legs (
  id INTEGER IDENTITY,
  yachtGroup INTEGER NOT NULL REFERENCES YachtGroups ON DELETE CASCADE,
  name VARCHAR(32) NOT NULL CHECK (length(trim(both from name)) > 0),
  system TINYINT, -- FIXME: enum?
  notes VARCHAR(64),
  );
  
CREATE TABLE Participants (
  yacht INTEGER NOT NULL REFERENCES Yachts,
  yachtGroup INTEGER NOT NULL REFERENCES YachtGroups ON DELETE CASCADE,
  captain VARCHAR(64),
  owner  VARCHAR(64),
  sponsors VARCHAR(64),
  PRIMARY KEY(yacht, yachtGroup) -- FIXME: neleisti dalyvauti toje pačioje regatoje keliose grupėse (pridėti išorinį raktą arba trigerį)
  );
  
CREATE TABLE Swimmings (
  yacht INTEGER NOT NULL REFERENCES Yachts,
  leg INTEGER NOT NULL REFERENCES Legs ON DELETE CASCADE,
  startTime TIMESTAMP,
  finishTime TIMESTAMP,
  code INTEGER, -- FIXME: enum?
  notes VARCHAR(64),
  PRIMARY KEY(yacht, leg) -- jachta etape plaukia tik kartą
  );

CREATE INDEX yachtClass ON Yachts (yachtClass);

-- TODO: perrašyti trigerius iš plpgsql į Java
-- Jachta negali būti pagaminta anksčiau, negu suprojektuotas jos modelis
CREATE FUNCTION YachtYear()
  RETURNS "trigger" AS
  '
    BEGIN
      IF (SELECT COALESCE(projectYear, 0) FROM yachtClasses WHERE id = NEW.yachtClass) > COALESCE(NEW.buildYear, 0)
        THEN
	  RAISE EXCEPTION ''Jachta negali būti pagaminta anksčiau, negu buvo suprojektuota.'';
	END IF;
	RETURN NEW;
    END;
  '
  LANGUAGE 'plpgsql';
CREATE TRIGGER yachtYear
  AFTER INSERT OR UPDATE ON Yachts
  FOR EACH ROW EXECUTE PROCEDURE YachtYear();

-- Modelis negali būti suprojektuotas vėliau, negu yra pagaminta kokia nors to modelio jachta
CREATE FUNCTION YachtClassYear()
  RETURNS "trigger" AS
  '
    BEGIN
      IF (SELECT COUNT(*) FROM Yachts WHERE yachtClass = NEW.id AND buildYear > NEW.projectYear) > 0
        THEN
	  RAISE EXCEPTION ''Modelis negali būti suprojektuotas anksčiau, negu yra pagaminta kokia nors to modelio jachta.'';
	END IF;
	RETURN NEW;
    END;
  '
  LANGUAGE 'plpgsql';
CREATE TRIGGER yachtClassYear
  AFTER UPDATE ON YachtClasses
  FOR EACH ROW EXECUTE PROCEDURE YachtClassYear();
