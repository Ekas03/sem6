interface ReportBuilder {
    fun setTitle(title: String): ReportBuilder
    fun setTask(task: String): ReportBuilder
    fun setAnnotation(annotation: String): ReportBuilder
    fun setTableOfContents(contents: String): ReportBuilder
    fun setReport(report: String): ReportBuilder
    fun setSources(sources: String): ReportBuilder
    fun setAppendix(appendix: String): ReportBuilder
    fun build(): String
}

class OSReportBuilder : ReportBuilder {
    private var report = "Отчет по ОС: "

    override fun setTitle(title: String): ReportBuilder {
        report += "\nНазвание: $title"
        return this
    }

    override fun setTask(task: String): ReportBuilder {
        report += "\nЗадание: $task"
        return this
    }

    override fun setAnnotation(annotation: String): ReportBuilder {
        report += "\nАннотация: $annotation"
        return this
    }

    override fun setTableOfContents(contents: String): ReportBuilder {
        report += "\nСодержание: $contents"
        return this
    }

    override fun setReport(report: String): ReportBuilder {
        this.report += "\nОтчет: $report"
        return this
    }

    override fun setSources(sources: String): ReportBuilder {
        report += "\nИсточники: $sources"
        return this
    }

    override fun setAppendix(appendix: String): ReportBuilder {
        report += "\nПриложения: $appendix"
        return this
    }

    override fun build(): String {
        return report
    }
}

class ProjectReportBuilder : ReportBuilder {
    private var report = "Отчет по АВС: "

    override fun setTitle(title: String): ReportBuilder {
        report += "\nНазвание: $title"
        return this
    }

    override fun setTask(task: String): ReportBuilder {
        report += "\nЗадание: $task"
        return this
    }

    override fun setAnnotation(annotation: String): ReportBuilder {
        report += "\nАннотация: $annotation"
        return this
    }

    override fun setTableOfContents(contents: String): ReportBuilder {
        report += "\nСодержание: $contents"
        return this
    }

    override fun setReport(report: String): ReportBuilder {
        this.report += "\nОтчет: $report"
        return this
    }

    override fun setSources(sources: String): ReportBuilder {
        report += "\nИсточники: $sources"
        return this
    }

    override fun setAppendix(appendix: String): ReportBuilder {
        report += "\nПриложения: $appendix"
        return this
    }

    override fun build(): String {
        return report
    }
}

fun main() {
    val osReport = OSReportBuilder()
    val labReport = osReport
        .setTitle("MacOS")
        .setTask("Всё об MacOS")
        .setAnnotation("MacOS - супер!")
        .setTableOfContents("1. Введение\n2. Рассуждения\n3. Иоги\n4. Вывод")
        .setReport("MacOS - ос apple")
        .setSources("Разные книжки")
        .setAppendix("Котик")
        .build()

    println(labReport)

    val AVSReportBuilder = ProjectReportBuilder()
    val projectReport = AVSReportBuilder
        .setTitle("АВС")
        .setTask("Введение в АВС")
        .setAnnotation("АВС - супер!")
        .setTableOfContents("1. Введение\n2. Рассуждения\n3. Иоги\n4. Вывод")
        .setReport("АВС надо знать")
        .setSources("Много книг")
        .setAppendix("Собачка")
        .build()

    println(projectReport)
}