package de.juli.newjob.controller.aplaystate;

/**
 * Triggert ggf. eine Wiedereroeffnung eines Bewergunsprozesses 
 * Auf das Schliessen einer Bewerbung sind f olgene Stausaenderungen moeglich:
 * 
 * {@link ReOpen}, {@ Deleted}
 * 
 * Methodenaufrufe keine plausieble Stausfolge liefern geben das unveraenderte Statusobjekt 'this' zurueck.
 * 
 * Die Statusfolgen ist:
 *  
 * {@link Started} = Eine neue Bewerbung soll angelgt werden    
 * {@link Created} = Bewebungsdaten sind angelegt und peristiert   
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
public class Closed extends State {

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
		if(controller.run(this, "Bewerbung wird gek�scht, nachdem sie gschlossen wurde")) {
			return StateContext.DELETED;
		}
		return this;
	}

	@Override
	public State reopen() {
		if(controller.run(this, "Bewerbung wird widerer�ffnet, nachdem sie gschlossen wurde")) {
			return StateContext.RE_OPEN;
		}
 		return this;
	}

	@Override
	public State close() {
		return this;
	}

}
