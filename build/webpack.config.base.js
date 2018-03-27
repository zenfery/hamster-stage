var path = require('path');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var CleanWebpackPlugin = require('clean-webpack-plugin');

// Dir
//var resourcesDir = "./src/main/resources";
var publicDir = "./public"; // 前面的 './' 不能省略，否则无法解析
var srcDir = publicDir;
var distDir = "../src/main/webapp";
var srcEjsDir = publicDir;

module.exports =
{
    entry: {
        demo: srcDir + "/demo-main.js",
    },
    output: {
        path: path.resolve(__dirname, distDir),
        publicPath: "//localhost:8080",
        filename: "[name].js",
    },
    plugins: [
        new CleanWebpackPlugin([distDir]),
        new HtmlWebpackPlugin({
            filename: "demo.html",
            //title: "This is create by webpack, for vue.",
            template: srcEjsDir + "/demo.ejs",
            xhtml: true,
            inject: true,
            chunks: ["demo"],
        }),
    ],
    module: {
        rules: [
            {
                test: /\.(png|jpg|gif)$/,
                loader: 'url-loader',
            },
            {
                test: /\.less$/,
                loader: 'style-loader!css-loader!less-loader',
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader',
                options: {
                    loaders: {
                        // you need to specify `i18n` loaders key with `vue-i18n-loader` (https://github.com/kazupon/vue-i18n-loader)
                        i18n: '@kazupon/vue-i18n-loader'
                    }
                }
            },

        ],
    },
    resolve: {
        alias: {
            "vue": "vue/dist/vue.js",
        }
    }
};
