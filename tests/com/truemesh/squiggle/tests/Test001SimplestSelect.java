package com.truemesh.squiggle.tests;

import com.truemesh.squiggle.Order;
import com.truemesh.squiggle.SelectQuery;
import com.truemesh.squiggle.Table;
import static com.truemesh.squiggle.tests.SqlMatcher.generatesSql;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class Test001SimplestSelect {
    @Test
    public void simpleSelect() {
        Table people = new Table("people");

        SelectQuery select = new SelectQuery(people);

        select.addColumn(people, "firstname");
        select.addColumn(people, "lastname");

        select.addOrder(people, "age", Order.DESCENDING);

        assertThat(select, generatesSql(
                "SELECT  people.firstname , people.lastname " +
                "FROM people " +
                "ORDER BY people.age DESC"));
    }
}