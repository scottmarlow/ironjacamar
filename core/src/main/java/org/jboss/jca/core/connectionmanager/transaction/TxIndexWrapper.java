package org.jboss.jca.core.connectionmanager.transaction;

import javax.transaction.Transaction;

/**
 * TxIndexWrapper acts as a key for a transaction that could be used as a key for a Map:
 *
 * Usage:
 *
 *  map.get(new TxIndexWrapper(transaction)) to lookup a transaction from a Map<TxIndexWrapper, Object>
 *
 *  map.put(new TxIndexWrapper(transaction), value) to add a transaction to a Map<TxIndexWrapper, Object>
 *
 * @author Scott Marlow
 * @author Dimitris Andreadis
 */
public class TxIndexWrapper {

    private final Transaction tx;
    private final int hashcode;
    public TxIndexWrapper(Transaction tx) {
        this.tx = tx;
        hashcode = tx != null ? System.identityHashCode(tx) : 1;

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TxIndexWrapper))
            return false;
        TxIndexWrapper other = (TxIndexWrapper) o;
        return this.tx == other.tx;
    }

    @Override
    public int hashCode() {
        return hashcode;
    }
}
