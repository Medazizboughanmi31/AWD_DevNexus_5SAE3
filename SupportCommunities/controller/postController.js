const PostService = require('../services/postService');

class PostController {
    static async createPost(req, res) {
        try {
            const post = await PostService.createPost(req.body);
            res.status(201).json(post);
        } catch (err) {
            res.status(500).json({ message: err.message });
        }
    }

    static async getAllPosts(req, res) {
        try {
            const posts = await PostService.getAllPosts();
            res.status(200).json(posts);
        } catch (err) {
            res.status(500).json({ message: err.message });
        }
    }

    static async getPostById(req, res) {
        try {
            const post = await PostService.getPostById(req.params.id);
            if (!post) return res.status(404).json({ message: 'Post not found' });
            res.status(200).json(post);
        } catch (err) {
            res.status(500).json({ message: err.message });
        }
    }

    static async deletePost(req, res) {
        try {
            const post = await PostService.deletePost(req.params.id);
            res.status(200).json({ message: 'Post deleted', post });
        } catch (err) {
            res.status(500).json({ message: err.message });
        }
    }
}

module.exports = PostController;
