/***********************************************************************
 * Module:  Subscriber.java
 * Author:  Nikola
 * Purpose: Defines the Class Subscriber
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid b209f214-d043-4250-979b-535947067e48 */
public class Subscriber implements ISubscriber {
   /** @pdRoleInfo migr=no name=Observer assc=association5 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Observer> observer;
   
   /** @param observer
    * @pdOid b5b20985-80a9-465a-99f9-c13b1054ec50 */
   public void subscribe(Observer observer) {
      // TODO: implement
   }
   
   /** @param observer
    * @pdOid 61345d61-3a6e-439c-ba94-482be2794d3a */
   public void unsubscribe(Observer observer) {
      // TODO: implement
   }
   
   /** @pdOid 0f83b48f-17cc-4596-8606-a64134f1c5c7 */
   public void notifyObservers() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Observer> getObserver() {
      if (observer == null)
         observer = new java.util.HashSet<Observer>();
      return observer;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorObserver() {
      if (observer == null)
         observer = new java.util.HashSet<Observer>();
      return observer.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newObserver */
   public void setObserver(java.util.Collection<Observer> newObserver) {
      removeAllObserver();
      for (java.util.Iterator iter = newObserver.iterator(); iter.hasNext();)
         addObserver((Observer)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newObserver */
   public void addObserver(Observer newObserver) {
      if (newObserver == null)
         return;
      if (this.observer == null)
         this.observer = new java.util.HashSet<Observer>();
      if (!this.observer.contains(newObserver))
         this.observer.add(newObserver);
   }
   
   /** @pdGenerated default remove
     * @param oldObserver */
   public void removeObserver(Observer oldObserver) {
      if (oldObserver == null)
         return;
      if (this.observer != null)
         if (this.observer.contains(oldObserver))
            this.observer.remove(oldObserver);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllObserver() {
      if (observer != null)
         observer.clear();
   }

}