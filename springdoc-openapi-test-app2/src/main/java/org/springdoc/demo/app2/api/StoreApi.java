/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.springdoc.demo.app2.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.demo.app2.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Map;

@javax.annotation.Generated(value = "org.springdoc.demo.app2.codegen.languages.SpringCodegen", date = "2019-07-11T00:09:29.839+02:00[Europe/Paris]")

@Tag(name = "store", description = "the store API")
public interface StoreApi {

    default StoreApiDelegate getDelegate() {
        return new StoreApiDelegate() {
        };
    }

    @Operation(summary = "Delete purchase order by ID", description = "For valid response try integer IDs with value < 1000. Anything above 1000 or nonintegers will generate API errors", tags = {"store"})
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Order not found")})
    @DeleteMapping(value = "/store/order/{orderId}")
    default ResponseEntity<Void> deleteOrder(
            @Parameter(description = "ID of the order that needs to be deleted", required = true, schema = @Schema(type = "integer", format = "int64")) @PathVariable("orderId") Long orderId) {
        return getDelegate().deleteOrder(orderId);
    }

    @Operation(summary = "Returns pet inventories by status", description = "Returns a map of status codes to quantities", security = {
            @SecurityRequirement(name = "api_key")}, tags = {"store"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(type = "object")))})
    @GetMapping(value = "/store/inventory", produces = {"application/json"})
    default ResponseEntity<Map<String, Integer>> getInventory() {
        return getDelegate().getInventory();
    }

    @Operation(summary = "Find purchase order by ID", description = "For valid response try integer IDs with value <= 5 or > 10. Other values will generated exceptions", tags = {"store"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Order.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found", content = @Content)
    })
    @GetMapping(value = "/store/order/{orderId}", produces = {"application/xml", "application/json"})
    default ResponseEntity<Order> getOrderById(
            @Min(1L) @Max(5L) @Parameter(description = "ID of order that needs to be fetched", required = true) @PathVariable("orderId") Long orderId) {
        return getDelegate().getOrderById(orderId);
    }

    @Operation(summary = "Place an order for a pet", description = "Place a new order in the store", tags = {"store"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Order.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input", content = @Content)
    })
    @PostMapping(value = "/store/order", produces = {"application/json"}, consumes = {"application/xml", "application/json", "application/x-www-form-urlencoded"})
    default ResponseEntity<Order> placeOrder(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "") @Valid @RequestBody Order order) {
        return getDelegate().placeOrder(order);
    }

}
