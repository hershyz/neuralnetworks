<h1>hershyz/neuralnetworks</h1>
</p>Experimental code in different languages relating to neural networks, deep learning, and machine learning.</p>

<h3>Java:</h3>
<pre>
<strong>java/positive correlation perceptron:</strong>
A neural network that makes predictions based on positively correlated input data.
This network automatically terminates training when predictions are satisfactory according to a given error margin.
</pre>
<pre>
<strong>java/intercept regression perceptron:</strong>
A neural network that makes predictions based on positively or negatively correlated non zero input data.
This network uses a regression (sort of) algorithm in infinite dimensions.
A baseline intercept is calculated, which also sets starting weights for each input column.
The weights are adjusted over time until the set number of epochs have been completed.
Data with outliers should not be used in this network as they break the training algorithm.
</pre>
<pre>
<strong>java/outlier identifier:</strong>
Small library that idenfifies outliers in a set of data.
Identifying and eliminating outliers from training datasets will increase the accuracy of a model's predictions.
</pre>
