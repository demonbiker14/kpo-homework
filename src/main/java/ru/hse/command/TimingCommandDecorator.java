package ru.hse.command;

public class TimingCommandDecorator implements Command {
    private final Command wrapped;

    public TimingCommandDecorator(Command wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void execute() {
        long start = System.nanoTime();
        wrapped.execute();
        long end = System.nanoTime();
        System.out.print("Время: " + (double)(end - start) / 1_000_000.0 + "мс");
    }
}