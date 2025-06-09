const mongoose = require('mongoose'); 
 const URI = 'mongodb+srv://aherrancorredor:AkWV1hNsWO6fMIW1@cluster0.xjagwvf.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0'; 
 mongoose.connect(URI)
     .then(db => console.log('DB is connected'))
     .catch(err => console.error(err));  
 module.exports = mongoose; 