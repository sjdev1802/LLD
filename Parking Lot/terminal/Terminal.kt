import usecase.Printer

abstract class Terminal(val id: String, printer: Printer) {
    abstract val type: String
}