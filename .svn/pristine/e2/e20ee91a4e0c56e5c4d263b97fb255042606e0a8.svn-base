/***********************************************************************
 * Module:  DeleteCommand.java
 * Author:  Nikola
 * Purpose: Defines the Class DeleteCommand
 ***********************************************************************/

package command;

import model.TableModel;

/** @pdOid 956c8d33-bc04-4c33-9d23-570782a7cfa3 */
public class DeleteCommand extends TableCommand {
   private int deleteIndex;
   private TableModel model;
	public DeleteCommand(int deleteIndex, TableModel model) {
		this.deleteIndex = deleteIndex;
		this.model = model;
	}
   public void execute() {
	   model.removeRow(this.deleteIndex);
   }
   
   /** @pdOid 949c1b1d-07a4-4118-b277-e80bbbbf4875 */
   public void unexecute() {
      // TODO: implement
   }

}