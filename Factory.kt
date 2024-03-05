interface Product {
    val id: Int
    val name: String
    val price: Double
    fun displayDetails()
}

class Motherboard(
    override val id: Int,
    override val name: String,
    override val price: Double,
    val socketType: String,
    val processorCount: Int,
    val ramType: String
) : Product {
    override fun displayDetails() {
        println("Материнская плата $name - Сокет: $socketType, Количество процессоров: $processorCount, RAM: $ramType")
    }
}

class Processor(
    override val id: Int,
    override val name: String,
    override val price: Double,
    val socketType: String,
    val coreCount: Int,
    val clockSpeed: Double
) : Product {
    override fun displayDetails() {
        println("Процессор $name - Сокет: $socketType, Количество ядер: $coreCount, Скорость: $clockSpeed")
    }
}

class HardDrive(
    override val id: Int,
    override val name: String,
    override val price: Double,
    val capacity: Int,
    val rotationSpeed: Int
) : Product {
    override fun displayDetails() {
        println("Жесткий диск $name - Вместительность: $capacity GB, Скорость: $rotationSpeed")
    }
}

class ProductFactory {
    fun createMotherboard(itemNumber: Int, name: String, price: Double, socketType: String, processorCount: Int, ramType: String): Motherboard {
        return Motherboard(itemNumber, name, price, socketType, processorCount, ramType)
    }

    fun createProcessor(itemNumber: Int, name: String, price: Double, socketType: String, coreCount: Int, clockSpeed: Double): Processor {
        return Processor(itemNumber, name, price, socketType, coreCount, clockSpeed)
    }

    fun createHardDrive(itemNumber: Int, name: String, price: Double, capacity: Int, rotationSpeed: Int): HardDrive {
        return HardDrive(itemNumber, name, price, capacity, rotationSpeed)
    }
}

class ProductDB(private val productFactory: ProductFactory) {
    private val products = listOf<Product>(
        productFactory.createMotherboard(1, "Gigabyte", 13000.0, "1423", 1, "DDR4"),
        productFactory.createMotherboard(2, "AMD", 12900.0, "2342", 3, "DDR4"),
        productFactory.createProcessor(3, "Intel Core i5", 15000.0, "2412", 4, 6.0),
        productFactory.createHardDrive(4, "SSD 1TB", 100.0, 1000, 5000),
        productFactory.createHardDrive(5, "HDD 3TB", 100.0, 1000, 4500)
    )

    fun displayAllProducts() {
        products.forEach {
            println("${it.id}: ${it.name}")
        }
    }

    fun displayProductDetails(itemNumber: Int) {
        val product = products.find { it.id == itemNumber }
        if (product != null) {
            product.displayDetails()
        } else {
            println("Такого товара нет")
        }
    }
}

fun main() {
    val productFactory = ProductFactory()
    val database = ProductDB(productFactory)
    database.displayAllProducts()
    database.displayProductDetails(1)
    database.displayProductDetails(2)
    database.displayProductDetails(4)
}

