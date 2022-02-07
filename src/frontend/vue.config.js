const path = require('path')

module.exports = {
    outputDir: path.resolve(__dirname, "../"+"main/resources/static"),
    devServer: {
        proxy: {
            '/api' : {
                target:'https://vue-board-w-boot.herokuapp.com/',
                ws: true,
                changeOrigin:true
            },
        }
    }
}