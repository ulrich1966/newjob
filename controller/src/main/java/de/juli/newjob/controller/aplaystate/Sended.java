package de.juli.newjob.controller.aplaystate;

/**
 * Triggert das Setzten des Stauses nach dem Senden auf {@link InProgress}, 
 * sofern das Versenden der Dokumente erfolgreich war. 
 * 
 * Nach dem Senden der Bewerbung sind volgene Stausaenderungen moeglich:
 * 
 * {@link InProgress}
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
 *
 */
public class Sended extends State {

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
		if(controller.run(this, "Bewerbung wird in den Berberbunsprozess übergeleitet")) {
			return StateContext.IN_PROGRESS;
		}
		return this;
	}

	@Override
	public State reply() {
		return this;
	}

	@Override
	public State interview() {
		return this;
	}

	@Override
	public State refuse() {
		return this;
	}

	@Override
	public State retract() {
		return this;
	}

	@Override
	public State hire() {
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
