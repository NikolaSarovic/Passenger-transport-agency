/***********************************************************************
 * Module:  Command.java
 * Author:  Nikola
 * Purpose: Defines the Interface Command
 ***********************************************************************/

package command;

import java.util.*;

/** @pdOid 36096f78-bf11-44da-ba68-aa616efb8ee0 */
public interface Command {
   /** @pdOid e191bfae-0070-4c59-b3a4-d9bd27a8a763 */
   void execute();
   /** @pdOid 418e0ce7-c4eb-4a72-a8a5-ab9e21cb4180 */
   void unexecute();

}