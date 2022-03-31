# flooring-material-cost
<h1>Language and Framework</h1>
Java (eclipse)

<h2>Overview</h2>
Produce a table of estimated prices for several
different flooring materials for any customer-specified room size. A waste ratio will to be included with each quote.


<h3>Design</h3>

Inches are used for all
calculations (but displays results with feet and inches). Floors are the same rectangular shape but the material type of the flooring (i.e.
concrete, hardwood, linoleum, ceramic tiles...) can change the way to calculate the required
amount.

The quotes are based on the total
amount of material to buy at a price per square inch (that must be calculated for some
materials) plus a contractor markup. 

The materials fall into several distinct categories: poured
material (i.e. concrete, rubber), rolls of material (i.e. linoleum, carpeting), planks of material (i.e.
wood planks, composite planks), and square tiles (i.e. ceramic, porcelain). 

Certain sizes of floors coupled with the type of material can create a lot of wasted material. This program ensures
there is enough material to cover the floor.

Conceptually, each flooring type has a price per square inch, a way of computing how much
material needs to cover a particular floor, and a way of computing a waste ratio. The Table accurately displays all the necessary information.
