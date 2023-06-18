package app;

import java.util.*;

import static app.ScopeType.SPECIFICATION;

public class SymbolTable {

    protected Stack<Scope> scopeStack;
    protected ArrayList<Scope> allScopes;
    protected int genId;

    public SymbolTable() {
        init();
    }

    protected void init() {
        scopeStack = new Stack<>();
        allScopes = new ArrayList<>();

        genId = 0;
        Scope allFater = new Scope(genId, "Specification", SPECIFICATION);

        allScopes.add(allFater);
        scopeStack.push(allFater);
    }

    public Scope getFather(){

        return allScopes.get(0);
    }

    public Scope pushScope(String scopeName, ScopeType scopeType) {
        Scope father = scopeStack.peek();
        Scope scope = new Scope(nextGenId(), father, scopeName, scopeType);
        father.addChildScope(scope);
        scopeStack.push(scope);
        allScopes.add(scope);
        return scope;
    }

    public void popScope() {
        scopeStack.pop();
    }

    public Scope currentScope() {
        if (scopeStack.size() > 0) {
            return scopeStack.peek();
        }
        return allScopes.get(0);
    }

    public Scope getScope(int genId) {
        for (Scope scope : scopeStack) {
            if (scope.genId == genId) return scope;
        }
        return null;
    }

    private int nextGenId() {
        genId++;
        return genId;
    }

    public boolean testScopeName(Scope scope, String id, ScopeType scopeType){

        List<Scope> childScopes = scope.getChildScopes();

        for(Scope e : childScopes){

            if(e.getScopeType() == scopeType && e.getName().equals(id)){

                return true;
            }
        }

        return false;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Scope scope : scopeStack.subList(0, scopeStack.size() - 1)) {
            sb.append(scope.toString());
        }
        return sb.toString();
    }
}