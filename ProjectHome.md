Did you ever want to know how to place an element below a ScrollView which will normally fill the whole screen?
This is only possible by a little trick: Using margins.
The ScrollView must have positive layout\_marginBottom, and the element below the ScrollView must have negative layout\_marginTop.