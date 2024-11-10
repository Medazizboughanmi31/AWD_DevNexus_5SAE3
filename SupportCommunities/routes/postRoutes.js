const express = require('express');
const PostController = require('../controller/postController');
const router = express.Router();

// Define routes for posts
router.post('/', PostController.createPost);
router.get('/', PostController.getAllPosts);
router.get('/:id', PostController.getPostById);
router.delete('/:id', PostController.deletePost);

module.exports = router;
