package de.juli.newjob.controller.aplaystate;

/**
 * Triggert das Neuerstellen einer Bewerbung
 * 
 * Auf das Loeschen folgend sind folgende Statusaenderungen moeglich:
 * 
 * {@link Started}, {@link Documents} 
 * 
 * Methodenaufrufe keine plausieble Stausfolge liefern geben das unveraenderte
 * Statusobjekt 'this' zurueck.
 * 
 * Die Statusfolge ist:
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
public class Deleted extends State {

	@Override
	public State start() {
		if (controller.run(this, "Bewerbung neu starten")) {
			return StateContext.STARTED;
		}
		return this;
	}

	@Override
	public State create() {
		return this;
	}

	@Override
	public State documents() {
		if (controller.run(this, "Für die Bewerbung werden neue Dokumene erstellt")) {
			return StateContext.DOCUMENTS;
		}
	
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
