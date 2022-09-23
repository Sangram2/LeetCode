# Write your MySQL query statement below
select person.firstname,person.lastname,address.city,address.state from person left join address on person.personId = address.personId;


# SELECT Person.FirstName, Person.LastName, Address.City, Address.State
# FROM Person LEFT JOIN Address
# on Person.PersonId = Address.PersonId