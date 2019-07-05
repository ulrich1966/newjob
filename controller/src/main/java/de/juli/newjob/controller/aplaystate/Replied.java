package de.juli.newjob.controller.aplaystate;

/**
 * Triggert das Unstellen des Stauts bezogen auf die Raktion auf die Bewerbung.
 * Auf eine Antwort auf Bewerbung sind volgene Stausaenderungen moeglich:
 * 
 * {@link Refused}, {@link Retracted}, {@link Invited}, {@link Hired}
 * 
 * Methodenaufrufe keine plausieble Stausfolge liefern geben das unveraenderte Statusobjekt 'this' zurueck.
 * 
 * Die Statusfolgen ist:
 *  
 * {@link Started} = Eine neue Bewerbung soll angelgt werden    
 * {@link Created} = Bewebungsdaten sind angelegt und peristiert   
 * {@link Deleted} = Loescht eine Bewerbung   
 * {@link Documents} = Die Unterlagen fuer die Bewerbung wurden erzeugt
 * {@link Sended} = Die Unterlagen wurden versandt 
 * {@link InProgress} = Der Bewerbunsprozess ist gestartet, womit folgende unterschidliche Stausfolgen moeglich sind:
 * {@link Replied} = Die Bewerbung wurde beantwortet, der Erhalt wurde bestaetigt  
 * {@link Closed} = Auf die Bewerbung wurde eine Absage erhalten  
 * {@link Retracted} = Die Bewerbung wurde vom Erstelle zurueckgezogen
 * {@link Invited} = Auf die Bewerbung ist eine Einladung erfolgt 
 * {@link Hired} = Auf die Bewerbung ist eine Einstellung erfolgt 
 * {@link Closed} = Die Bewerbung ist geschlossen 
 * {@link ReOpen} = Auf die Bewerbung wurde wieder eroeffnet 
 *    
 * @author uli
 *
 */
public class Replied extends State {

	@Override
	public State start() {
		return this;
	}

	@Override
	public State create() {
		return this;
	}

	@Override
	public State documents() {
		return this;
	}

	@Override
	public State send() {
		return this;
	}

	@Override
	public State inProgress() {
		return this;
	}

	@Override
	public State reply() {
		return this;
	}

	@Override
	public State interview() {
		if(controller.run(this, "Nach Rückmeldung erfolgte eine Einldung")) {
			return StateContext.INVITED;
		}
		return this;
	}

	@Override
	public State refuse() {
		if(controller.run(this, "Nach Rückmeldung wurde eine Absage erteilt")) {
			return StateContext.REFUSED;
		}
		return this;
	}

	@Override
	public State retract() {
		if(controller.run(this, "Nach Rückmeldung wird die Bewerbung zurückgezogen")) {
			return StateContext.RETRACTED;
		}
		return this;
	}

	@Override
	public State hire() {
		if(controller.run(this, "Nach Rückmeldung erfolgt die Einstellung")) {
			return StateContext.HIRED;
		}
		return this;
	}

	@Override
	public State delete() {
		return this;
	}

	@Override
	public State reopen() {
		return this;
	}

	@Override
	public State close() {
		return this;
	}

}
