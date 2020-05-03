![Java CI with Gradle](https://github.com/ravindraAmbati/java8/workflows/Java%20CI%20with%20Gradle/badge.svg?branch=master)
# java8
<h2>New Functional Interfaces in Java 8</h2>
<ul>
    <li>Lambda = (method parameters)->{method definition}</li>
    <li>Method Reference - a shorcut to Lambdas = className::methodName</li>
</ul> 
<h4>java.util.functions</h4>
    <ul>
        <li>Consumer, BiConsumer</li>
        <li>Function, BiFunction, UnaryOperator, BinaryOperator</li>
        <li>Predicate, BiPredicate</li>
        <li>Supplier</li>
    </ul>
<h4>java.util.streams</h4>
    <ul>
        <li> add or remove operations can be done on collections only </li>
        <li> add or remove operations cannot be done on streams </li>
        <li> students.stream().add </li>
        <li> students.stream().re </li>
        <li> can get particular object </li>
        <li> cannot get any particular object </li>
        <li> log.info(students.stream().get); </li>
        <li> Streams are lazy performed - intermediate operations cannot be performed if terminal operations are not performed </li>
        <li> intermediate operations are filters </li>
        <li> terminal operations are collect </li>
        <li> Collections are eagerly construct </li>
        <li> Stream are lazy construct only invoke if terminal operations </li>
        <li> Collections are travers multiple times </li>
        <li> Stream are travers only once </li>
        <li> Collections iterate external </li>
        <li> Stream iterate internal </li>
        <li> studentGradeGreaterThan3Stream.collect(Collectors.toList()).forEach(s->log.info(s.toString())); </li>
        <li> it has been closed or stopped </li>
    </ul> 
    
