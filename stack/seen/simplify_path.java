class Solution {
    public String simplifyPath(String path) {
        int len = path.length();
        String[] dirs = path.split("/");
        List<String> list = new ArrayList();
        for (String s: dirs) {
            if (s.equals("..")) {
                int index = list.size()-1;
                if(index >=0) list.remove(index);
            } else if (s.equals(".") || s.isEmpty()) {
                continue;
            } else {
                list.add(s);
            }
        }
                
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append("/");
            sb.append(s);
        }
        
        String result =  sb.toString();        
        return result.equals("") ? "/" : result;
    }
}
