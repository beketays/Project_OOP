package Actors;

import java.io.IOException;
import java.io.Serializable;
import java.lang.*;
import java.util.Collections;
import java.util.Vector;

import Comparators.RequestComparator;
import Enums.Language;
import Enums.MessageType;
import Enums.Status;
import SubSystems.Translator;
import Tools.*;

// TODO: Auto-generated Javadoc
/**
 * The Class TechSpecialist.
 */
public class TechSpecialist extends Employee implements DealerWithRequest, Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The requests. */
    private Vector<FixRequest> requests;

    /**
     * Instantiates a new tech specialist.
     *
     * @param key the key
     * @param name the name
     * @param surname the surname
     * @param id the id
     */
    public TechSpecialist(Key key, String name, String surname, String id) {
    	super(key,name,surname,id);
    	requests = new Vector<FixRequest>();
    }
    /**
     * Compare to.
     *
     * @param ts the ts
     * @return the int
     */
    public int compareTo(TechSpecialist ts) {
        return 0;
    }

    /**
     * See.
     *
     * @return the string
     */
    public void seeAll() {
    	for(FixRequest c : requests) {
    		c.setStatus(Status.SEEN);
    	}
    	Collections.sort(requests, new RequestComparator());
		db.printData(requests);
    }

    /**
     * Accept.
     *
     * @param r the r
     */
    public void accept(Request r) {
    	FixRequest c = (FixRequest)r;
    	c.setStatus(Status.ACCEPTED);
    }

    /**
     * Reject.
     *
     * @param r the r
     */
    public void reject(Request r) {
    	FixRequest c = (FixRequest)r;
    	c.setStatus(Status.REJECTED);
    }

    /**
     * To string.
     *
     * @return the string
     */
    public String toString() {
        return null;
    }

    public void logIn() throws IOException {
    	try {
			System.out.println(Translator.translate(" Welcome! "));
			main : while(true){
				Translator.printing(" :) MAIN PAGE \n 1) News \n 2) Change password \n"
						+ " 3) Change language \n 4) My journals \n 5) Messenger \n 6) Manage Fix Request \n 7) Log out ");
				int choice = in.nextInt();
				if(choice==1){
						seeNews();
						Translator.printing("\n 1) Go back ");
						choice = in.nextInt();
						if(choice==1)continue main;
						break;
				}
				else if (choice==2){
					changePassword: while(true){
						System.out.println(Translator.translate("\n Enter new password: "));
						setPassword();
						Translator.printing(" 1) Change password \n 2) Go back ");
						choice = in.nextInt();
						if(choice==1) continue changePassword;
						if(choice==2) continue main;
						break;
					}
				}
				else if (choice==3){
				
					System.out.println(" 1) KZ \n 2) RU \n 3) EN ");
					choice = in.nextInt();
					if(choice==1) changeLang(Language.KZ);
					if(choice==2) changeLang(Language.RU);
					if(choice==3) changeLang(Language.EN);
					continue main; 

				}
				else if (choice==4){
						db.printData(db.journals);
						Translator.printing(" 1) Subscribe journal \n 2) Unsubscribe journal \n 3) Go back ");
						choice = in.nextInt();
						if(choice == 1)subscriptionJournal(1);
						if(choice == 2)subscriptionJournal(2);
						if(choice == 3)continue main; 
						break;
				}
				else if(choice == 5) {
						System.out.println(" 1) Write a message \n 2) Received messages \n 3) Sent Message \n 4) Go back ");
						choice = in.nextInt();
						if(choice == 1) {
							System.out.println(Translator.translate(" Choose an index "));
							try {
								db.printData(db.employees);
								messaging();
							}catch(NullPointerException n){
								System.out.println(" No elements exist... ");
								continue main;
							}
						}
						if(choice == 2) {
							for(Message m : messages) {
								if(m.type == MessageType.RECEIVED) {
									System.out.println(m);
									m.status = Status.SEEN;
								}
							}
						}
						if(choice == 3) {
							for(Message m : messages) {
								if(m.type == MessageType.SENT) System.out.println(m);
							}
						}
						if(choice == 4) continue main;
						break;
					
				}
				else if(choice == 6) {
					seeAll();
					System.out.println(Translator.translate(" Choose a fix request to handle "));
					int index = in.nextInt();
					FixRequest c = requests.get(index-1);
					Translator.printing(" 1) Accept \n 2) Reject 3) Go back ");
					choice = in.nextInt();
					if(choice == 1)accept(c);
					if(choice == 1)reject(c);
					else continue main; break; 
				}
				else if (choice==7){
					logOut();
					break main;
				}
			}
		} catch (Exception e) {
			System.err.println(" Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
    }
	/**
	 * Gets the requests.
	 *
	 * @return the requests
	 */
	public Vector<FixRequest> getRequests() {
		return requests;
	}

	/**
	 * Sets the requests.
	 *
	 * @param requests the new requests
	 */
	public void setRequests(Vector<FixRequest> requests) {
		this.requests = requests;
	}
}

