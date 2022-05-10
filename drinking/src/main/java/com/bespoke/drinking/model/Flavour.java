package com.bespoke.drinking.model;


public enum Flavour {
	SWEET("Sweet"),
	SALTY("Salty"),
	UMAMI("Umami"),
	BITTER("Bitter"),
	SOUR("Sour");
	
	String flavour;
	
	private Flavour(String flavour) { this.flavour = flavour; }
	
	@Override
	public String toString() {
		return this.flavour;
	}
	
	public static Flavour fromString(String text) {
        for (Flavour f : Flavour.values()) {
            if (f.toString().equalsIgnoreCase(text)) {
                return f;
            }
        }
        return null;
	}
}
