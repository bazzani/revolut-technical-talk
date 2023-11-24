package revolut.technical.talk;

import java.math.BigDecimal;

public class BalanceTransferService {
    void transfer(Account from, Account to, BigDecimal amount) {
        // sort the accounts by id to ensure the locking happens in order

        synchronized (from) {
            synchronized (to) {
                BigDecimal fromBalance = from.withdrawal(amount);
                BigDecimal toBalance = to.lodge(amount);
            }
        }
    }
}

//
// https://www.baeldung.com/java-double-vs-bigdecimal

//
// https://jvmaware.com/optimistic-pessimistic-locking/
//t1 Ac1 Ac2
//t2 Ac1 Ac2
//
//t1 Ac1 Ac2
//t2 Ac2 Ac1

//
// DB Isolation Levels
// https://jlvbcoop.com/en/transaction-isolation-levels-2/
// https://www.geeksforgeeks.org/transaction-isolation-levels-dbms/

//
// DB Bi-Tree, balanced tree
// https://www.javatpoint.com/binary-tree-vs-b-tree#:~:text=Btree%20is%20implemented%20when%20the,Huffman%20coding%20and%20code%20optimization.
// Partitioning

//
// Keep version number/timestamp in DB and check that it is not out of date before committing change
// https://sofienebk.medium.com/optimistic-locking-in-java-c29b0fe4bac

//
// client -> gateway --- (unstable) -> backend
//                          Redis cache
//                          Message Broker
// send txn id/trace-id to check if it has already been processed
// exponential backoff strategy

//
// Deployments, feature flags, NewRelic, caching performance, GCP autoscaling impl, scheduled before market opens and closes
