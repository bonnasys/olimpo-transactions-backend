package br.com.bonnasys.trasactions.domain.enums;

public enum PaymentState {

    CREATED {
        @Override
        public PaymentState next(PaymentState state) {
            if (CREATED.equals(state)) {
                throw new IllegalArgumentException("Payment already created");
            }
            return state;
        }
    },
    CONFIRMED {
        @Override
        public PaymentState next(PaymentState state) {
            if(CREATED.equals(state) || CONFIRMED.equals(state)) {
                throw new IllegalArgumentException("Invalid state");
            }
            return state;
        }
    },
    CANCELED {
        @Override
        public PaymentState next(PaymentState state) {
            throw new IllegalArgumentException("Payment already canceled");
        }
    },
    REFUNDED {
        @Override
        public PaymentState next(PaymentState state) {
            throw new IllegalArgumentException("Payment already refunded");
        }
    };


    public abstract PaymentState next(PaymentState state);

    public PaymentState next(PaymentState state, Runnable runnable) {
        PaymentState actualState = this.next(state);
        runnable.run();
        return actualState;
    }
}
