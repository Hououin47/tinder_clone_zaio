/**
 * Ontefetse Ditsele
 * 
 * 06 August 2020
 */
import java.util.*;

public class TinderSwipe {
    ArrayList<Profile> rightSwipes;
    ArrayList<Profile> preference;

    Database userData;
    Profile current;
    private int tracker = 0;
    private int right = 0;

	public TinderSwipe(String preference) {
        //this.preference = preference;
      rightSwipes = new ArrayList<Profile>();

        userData = new Database();
        userData.readCSV();
        userData.setPreference(preference);
    
        this.preference = userData.getPreference();
    }


	public Profile getNext() {
      if (tracker < preference.size()) {
          current = preference.get(tracker++);
      } else {
          return null;
      }
      return current;
	}
	public void right() {
      rightSwipes.add(current);
      userData.writeCSV(current);
    }

    public Profile[] getRightSwipes(){
        return this.preference.toArray(new Profile[0]);
    }
}
