<%@ page import="cg.wbd.grandemonstration.service.CustomerService" %>
<%@ page import="cg.wbd.grandemonstration.service.CustomerServiceFactory" %>
<%@ page import="cg.wbd.grandemonstration.model.Customer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%!--%>
<%--    private CustomerService customerService = CustomerServiceFactory.getInstance();--%>
<%--%>--%>
<%--<%--%>
<%--    Long id = Long.valueOf(request.getParameter("id"));--%>
<%--    Customer customer = customerService.findOne(id);--%>
<%--%>--%>
<form action="/customers" method="post" >
<fieldset>
    <legend>Customer Information</legend>
    <input type="hidden" name="id" value="<c:out value="${customer.id}" />"/>
    <table>
        <tr>
            <td>Id</td>
            <td>
                <c:out value="${customer.id}"/>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name" value="<c:out value="${customer.name}"/>"/>
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="email" value="<c:out value="${customer.email}"/>"/>
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td>
                <input type="text" name="address" value="<c:out value="${customer.address}"/>"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update">
            </td>
        </tr>
    </table>
</fieldset>
</form>
<a href="/customers">Back to list</a>