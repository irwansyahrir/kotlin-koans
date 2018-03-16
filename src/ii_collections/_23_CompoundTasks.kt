package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return customers.partition { it.orders.any { it.products.contains(product) } }.first.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return orders.filter { it.isDelivered }.flatMap { it.products }.toSet().maxBy { it.price }

}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    return customers.flatMap { it.orders }.toList()
            .flatMap { it.products }.toList().filter { it == product }.size
}
