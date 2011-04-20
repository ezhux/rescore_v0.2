package org.rescore.beans;

import java.util.ArrayList;
import java.util.List;

public class YachtClasses extends AbstractModelObject {
	private List<YachtClass> yachtClasses = new ArrayList<YachtClass>();

	public void addYachtClass(YachtClass yachtClass) {
		List<YachtClass> oldValue = yachtClasses;
		yachtClasses = new ArrayList<YachtClass>(yachtClasses);
		yachtClasses.add(yachtClass);
		firePropertyChange("yachtClasses", oldValue, yachtClasses);
	}

	public void removeYachtClass(YachtClass yachtClass) {
		List<YachtClass> oldValue = yachtClasses;
		yachtClasses = new ArrayList<YachtClass>(yachtClasses);
		yachtClasses.remove(yachtClass);
		firePropertyChange("yachtClasses", oldValue, yachtClasses);
	}

	public List<YachtClass> getYachtClasses() {
		return yachtClasses;
	}
}