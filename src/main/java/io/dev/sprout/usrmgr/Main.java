package io.dev.sprout.usrmgr;

import io.dev.sprout.usrmgr.controller.GroupRollController;
import io.dev.sprout.usrmgr.model.GroupRol;
import io.dev.sprout.usrmgr.persistence.Factory;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DEV sprout
 */
public class Main {

  public static void main(String[] args) {
    Map<String, String> map = new HashMap<String, String>();
    GroupRol result = null;
    GroupRollController controller = new GroupRollController();
    map.put("name", "dev");
    map.put("id", "1");
    // result = controller.findById(map);
    /*result = controller.save(map);*/

    /*Menu result = null;
    MenuController controller = new MenuController();
    map.put("name", "code");
    map.put("groupRolId", "1");
    result = controller.save(map);*/
    
    /*map.put("id", "1");
    map.put("name", "code upd");
    map.put("flagState", "false");
    map.put("flagVisible", "true");
    result = controller.update(map);
    map.put("id", "1");
    result = controller.delete(map);
    */

    

    /*if (result.getId() > 0) {
      System.out.println(result.objInfo());
    } else {
      System.err.println("bad");
    }*/
    Factory.closeFactory();
  }
}
