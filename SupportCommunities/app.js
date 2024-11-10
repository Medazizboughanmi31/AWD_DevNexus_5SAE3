const express = require('express');
const mongoose = require('mongoose');
require('dotenv').config();

// Import Routes
const postRoutes = require('./routes/postRoutes');
const challengeRoutes = require('./routes/challengeRoutes');
const supportCommunityRoutes = require('./routes/supportCommunityRoutes');

// Initialize the app
const app = express();

// Middlewares
app.use(express.json());  // For parsing application/json

// Database Connection
mongoose.connect(process.env.DB_URI, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
  serverSelectionTimeoutMS: 5000,  // 5 seconds
  socketTimeoutMS: 45000,  // 45 seconds
}).then(() => {
  console.log('Connected to MongoDB');
}).catch(err => {
  console.error('MongoDB connection error:', err);
});

// Use Routes
app.use('/api/posts', postRoutes);  // Routes for posts
app.use('/api/challenges', challengeRoutes);  // Routes for challenges
app.use('/api/communities', supportCommunityRoutes);  // Routes for support communities

// Start the server
const port = process.env.PORT || 3000;
app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
