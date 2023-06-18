package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Scope {

    public final int genId;

    private ScopeType scopeType;
    private String name;
    protected HashMap<String, Symbol> symbolMap = new LinkedHashMap<String, Symbol>();
    private Scope fatherScope;

    private List<Scope> childScopes = new ArrayList<>();

    public String getName() {
        return name;
    }

    public ScopeType getScopeType() {
        return scopeType;
    }

    public HashMap<String, Symbol> getSymbolMap() {
        return symbolMap;
    }

    public Scope getFatherScope() {
        return fatherScope;
    }

    public List<Scope> getChildScopes() {
        return childScopes;
    }


    public Scope(final int genId, Scope fatherScope, String name, ScopeType scopeType) {
        this.fatherScope = fatherScope;
        this.genId = genId;
        this.name = name;
        this.scopeType = scopeType;
    }

    public Scope(final int genId, String name, ScopeType scopeType){

        this.scopeType = scopeType;
        this.name = name;
        this.genId = genId;
    }
    /** Define a symbol in the current scope */
    public void define(Symbol symbol) {
        symbol.setScope(this);
        symbolMap.put(symbol.name, symbol);
    }

    public Scope getChild(String scopeName){

        for(Scope e: childScopes){

            if(e.getName().equals(scopeName)){

                return e;
            }
        }

        return null;
    }

    /**
     * Look up the symbol name in this scope and, if not found,
     * progressively search the enclosing scopes.
     * Return null if not found in any applicable scope.
     */
    private Symbol resolve(String name) {
        Symbol symbol = symbolMap.get(name);
        if (symbol != null) return symbol;
        return null; // not found
    }

    public String toString() {
        return symbolMap.keySet().toString();
    }

    public void addChildScope(Scope scope) {

        childScopes.add(scope);
    }
}