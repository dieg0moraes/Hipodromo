package persistencia;

public class StringBuilder {
    
    private String table;
    private String insert = "insert into ";
    private String sql;
    
    public StringBuilder setTable(String table){
        this.table = table;
        insert += table;
        return this;
    }
    
    public StringBuilder insert(){
        this.insert += "values ";
        return this;
    }
    
    public StringBuilder addValue(String key, String value){
        this.insert += "("+key+", "+value+")";
        return this;
    }
    
    public String get(){
        this.insert = this.insert.substring(0, this.insert.length() - 1);
        this.insert += ";";
        return this.insert;
    }
    
}
