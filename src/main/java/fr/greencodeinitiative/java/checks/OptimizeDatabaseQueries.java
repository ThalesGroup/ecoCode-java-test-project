package fr.greencodeinitiative.java.checks;

import org.springframework.data.jpa.repository.Query;

public class OptimizeDatabaseQueries {

    OptimizeDatabaseQueries(OptimizeDatabaseQueries mc) {
    }

    @Query("select t from Todo t where t.status != 'COMPLETED'") // Noncompliant
    public void literalSQLrequest() {
        dummyCall("SELECT user FROM myTable"); // Noncompliant
        dummyCall("SELECT user FROM myTable LIMIT 50"); // Compliant
    }


    @Query("select t from Todo t where t.status != 'COMPLETED' LIMIT 25") // Compliant

    private void callQuery() {
        String sql1 = "SELECT user FROM myTable"; // Noncompliant
        String sql2 = "SELECT user FROM myTable LIMIT 50"; // Compliant
    }

    private void dummyCall(String request) {
    }
}
