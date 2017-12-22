package ggxrd;

import java.util.Map;
import java.util.HashMap;

import org.neo4j.procedure.Name;
import org.neo4j.procedure.Description;
import org.neo4j.procedure.UserFunction;

public class GGXrd
{
    @UserFunction
    @Description("example.alv2frame(1, \"just\") - given attack lv, return stun frame.")
    public Number alv2frame (
                          @Name("attack lv") Number attack_lv,
                          @Name("type ( e.g. normal_ground, just_ground, fd_air, hit_stand, hit_crouch, hit_air ...)") String type
                          )
    {
        Map<String, int[]> hit = new HashMap<String, int[]>();
        hit.put("stand"  , new int[]{10, 12, 14, 17, 19});
        hit.put("crouch" , new int[]{10, 13, 15, 18, 20});
        hit.put("air"    , new int[]{10, 12, 14, 16, 18});

        Map<String, int[]> normal = new HashMap<String, int[]>();
        normal.put("ground" , new int[]{9, 11, 13, 16, 18});
        normal.put("air"    , new int[]{9, 11, 13, 16, 18});

        Map<String, int[]> just = new HashMap<String, int[]>();
        just.put("ground" , new int[]{7, 8, 10, 12, 14});
        just.put("air"    , new int[]{3, 5, 7,  9,  11});

        Map<String, int[]> fd = new HashMap<String, int[]>();
        fd.put("ground" , new int[]{11, 13, 15, 18, 20});
        fd.put("air"    , new int[]{11, 14, 17, 20, 23});

        Map<String, Map<String, int[]>> frame = new HashMap<String, Map<String, int[]>>();
        frame.put("hit"    , hit);
        frame.put("normal" , normal);
        frame.put("just"   , just);
        frame.put("fd"     , fd);
        
        String[] type_array = type.split("_", 0);
        return new Integer( frame.get(type_array[0]).get(type_array[1])[attack_lv.intValue()] );
    }
}
