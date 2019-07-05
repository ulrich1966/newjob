package de.juli.newjob.controller.aplaystate;

/**
 * Triggert das Unstellen des Stauts bezogen auf die Raktion auf die Bewerbung, loest 
 * die strikte Statusfolge auf und ernmoeglicht individuelle Aktonen. 
 * Auf die Umstellung nach {@link InProgress} sind volgene Stausaenderungen moeglich:
 * 
 * {@link Replied}, {@link Refused}, {@link Retracted}, {@link Invited}, {@link Hired}, {@link Closed}}
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
public class InProgress extends State {

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
		if(controller.run(this, "Antwort erhalen / Bewerbung ist eingegangen")) {
			return StateContext.REPLIED;
		}
		return this;
	}

	@Override
	public State interview() {
		if(controller.run(this, "Du bist eigeladen")) {
			return StateContext.INVITED;
		}
		return this;
	}

	@Override
	public State refuse() {
		if(controller.run(this, "Du wurdest abgelehnt")) {
			return StateContext.REFUSED;
		}
		return this;
	}

	@Override
	public State retract() {
		if(controller.run(this, "Die Bewerbung wird zurückgezogen")) {
			return StateContext.RETRACTED;
		}
		return this;
	}

	@Override
	public State hire() {
		if(controller.run(this, "Du bist eingestellt")) {
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
		if(controller.run(this, "Bewerbung wird geschlossen")) {
			return StateContext.CLOSE;
		}
		return this;
	}

}
