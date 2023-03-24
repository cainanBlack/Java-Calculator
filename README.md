# Java-Calculator
### Cainan Black - Belhaven University
<i>Java Calculator used for Senior Project.</i>

## Description of project:
 - End result will be a Functioning Java Calculator that is usable on most devices
 - Early satges of productivity, product should be complete around **May 2023**


## Commit One:
- First commit includes a functioning, simple calculator.
- Simple operations and general astetics.
- Next commit should include more operations and more efficeint calcuations. 


## Commit Two:
<i>Lots of bugs, <b>but buggs are progress.</b></i>

### Positives:
- Improved the visualization of the math, made the text field show all operations insted of clearing out after one operation.
- Added sin, cos, and tan buttons to get working on more complex operations.
- created a new JPanel to house the function buttons rather than just having them floating in the <i>ether</i>.

### Bugs:
- Operations are buggy, specifically multiplication and division. There is something about the way that I am storing my data that makes it compute incorrectly
- Order of Operations is non-existant. Thinking through ways to do order of operations right now, will hopefully have something soon.
- Sin, cos, and tan are giving some weird results. Not sure if the data from compilation is being stored wrong or what. Should, hopfully, be a easy fix.

>Biggest issue right now is the order of operations, this could cause a rather sizable bottleneck if I cannot figure out a good way to implement **PEMDAS**. Also, no one wants a calculator that just straight up gives them the wrong answers. There is an interesting feature in the early versions of Java that would make this issue a <i>breeze</i>, <b>but that feels like the quitters way out</b>. I will try to create a effeicant work around with the most recent version (_Java 19_). If you're reading this in the future and I reverted back to _Java 7_ or something; I'm sorry, I have failed. <b>Lol</b>.


## Commit Three:
<i>Great progress, still some issues!</i>

- Implemented the Shunting Yard Algorithmn to sort the equation created by the user into an easy to evaluate format. Once in the correct format, the equation is evalueated in order of operations and the final value is retunred as a string to be concatinated to the text field as the result. 
- Because everything is being done after the user enters values, the operations for the text field are a lot smoother now. All vlaues are just entered as string and the final string is evaluated. 

### Goals for the future:
- Add more buttons! (), pi, and ^ hopefully.
- Look into better design for the interface. 
