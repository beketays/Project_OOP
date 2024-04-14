package Tools;

import java.io.Serializable;

import Actors.User;
import Researcher.ResearchPaper;

// TODO: Auto-generated Javadoc
/**
 * The Class Journal.
 */
public class Journal extends Observable implements  Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The name. */
    public String name;

    /** The author. */
    private User author;

    /**
     * Instantiates a new journal.
     */
    public Journal() {}
    /**
     * Publish.
     *
     * @param rp the rp
     */
    public void publish(ResearchPaper rp) {
    }
}

