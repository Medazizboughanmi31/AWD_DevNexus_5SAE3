const { Post } = require('../models/post');

class PostService {
    // Create a new post
    static async createPost(postData) {
        try {
            const post = new Post(postData);
            return await post.save();
        } catch (err) {
            throw new Error('Error creating post: ' + err.message);
        }
    }

    // Get all posts
    static async getAllPosts() {
        try {
            return await Post.find().populate('createdBy', 'name email'); // Populate user data
        } catch (err) {
            throw new Error('Error retrieving posts: ' + err.message);
        }
    }

    // Get post by ID
    static async getPostById(postId) {
        try {
            return await Post.findById(postId).populate('createdBy', 'name email');
        } catch (err) {
            throw new Error('Error retrieving post: ' + err.message);
        }
    }

    // Delete a post
    static async deletePost(postId) {
        try {
            const result = await Post.findByIdAndDelete(postId);
            if (!result) throw new Error('Post not found');
            return result;
        } catch (err) {
            throw new Error('Error deleting post: ' + err.message);
        }
    }
}

module.exports = PostService;
