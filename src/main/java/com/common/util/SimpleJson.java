package com.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SimpleJson {

	    public Object toJSON(Object object) throws JSONException {
	        if (object instanceof HashMap) {
	            JSONObject json = new JSONObject();
	            HashMap map = (HashMap) object;
	            for (Object key : map.keySet()) {
	                json.put(key.toString(), toJSON(map.get(key)));
	            }
	            return json;
	        } else if (object instanceof Iterable) {
	            JSONArray json = new JSONArray();
	            for (Object value : ((Iterable)object)) {
	                json.put(toJSON(value));
	            }
	            return json;
	        } else {
	            return object;
	        }
	    }

	    public boolean isEmptyObject(JSONObject object) {
	        return object.names() == null;
	    }

	    public HashMap<String, Object> getMap(JSONObject object, String key) throws JSONException {
	        return toMap(object.getJSONObject(key));
	    }

	    public ArrayList getList(JSONObject object, String key) throws JSONException {
	        return toList(object.getJSONArray(key));
	    }

	    public HashMap<String, Object> toMap(JSONObject object) throws JSONException {
	        HashMap<String, Object> map = new HashMap();
	        Iterator keys = object.keys();
	        while (keys.hasNext()) {
	            String key = (String) keys.next();
	            map.put(key, fromJson(object.get(key)));
	        }
	        return map;
	    }

	    public ArrayList toList(JSONArray array) throws JSONException {
	        ArrayList list = new ArrayList();
	        for (int i = 0; i < array.length(); i++) {
	            list.add(fromJson(array.get(i)));
	        }
	        return list;
	    }

	    private Object fromJson(Object json) throws JSONException {
	        if (json == JSONObject.NULL) {
	            return null;
	        } else if (json instanceof JSONObject) {
	            return toMap((JSONObject) json);
	        } else if (json instanceof JSONArray) {
	            return toList((JSONArray) json);
	        } else {
	            return json;
	        }
	    }
}
