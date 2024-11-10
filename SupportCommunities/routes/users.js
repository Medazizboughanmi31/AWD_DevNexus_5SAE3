// routes/users.js
var express = require('express');
var router = express.Router();

// Example route for getting a list of users
router.get('/', function(req, res, next) {
  const users = [
    { id: 1, name: 'John Doe' },
    { id: 2, name: 'Jane Doe' },
  ];
  res.json(users); // Return the data as JSON
});

// Example route for adding a user
router.post('/', function(req, res, next) {
  const newUser = req.body; // Data sent in the request body
  // You can store the new user in a database here
  res.status(201).json(newUser); // Respond with the created user data
});

module.exports = router;
