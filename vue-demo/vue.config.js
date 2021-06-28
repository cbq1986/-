module.exports = {
    publicPath:"./",
    outputDir: "app",
    assetsDir: "static",
    indexPath: "index.html",
    filenameHashing: false,
    lintOnSave: false,
  
    runtimeCompiler: false,
  
    productionSourceMap: false,
  
    devServer: {
      host: "localhost",
      port: 8090, 
      https: false,
      open: true, 
  
      proxy: {
        "/api": {
          target: "http://localhost:8080", 
          changeOrigin: true,
          pathRewrite: {
            "^/api": "" 
          }
        }
      }
    }
  };