# Write your MySQL query statement below
SELECT
    (SELECT DISTINCT
         Salary
     FROM
         Employee
     ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary


select  ifnull(
    (select distinct Salary
    from Employee
    order by Salary desc
    limit 1 offset 1)
    ,null) as SecondHighestSalary
