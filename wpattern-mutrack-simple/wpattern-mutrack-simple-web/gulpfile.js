//Gulp como servidor 

// https://github.com/AveVlad/gulp-connect
// https://www.npmjs.com/package/gulp-inject

var gulp = require('gulp');
var connect = require('gulp-connect');

//Indicando pasta de conteudo do projeto 'app'
//Qualquer alteração do codigo, sera realizado um refresh na pagina
//Indicando porta de acesso ao projeto - 8087

gulp.task('connect', function() {
  connect.server({
    root: 'app',
    livereload: true,
    port: 8087
  });
});

//Monitoração dos arquivos web, qualquer alteração no html, css e js, a página será carregada.

//Monitorando o html
gulp.task('html', function () {
  gulp.src('./app/**/*.html')
    .pipe(connect.reload());
});

//Monitorando o js
gulp.task('js', function () {
  gulp.src('./app/**/*.js')
    .pipe(connect.reload());
});

//Monitorando o css
gulp.task('css', function () {
  gulp.src('./app/**/*.css')
    .pipe(connect.reload());
});

gulp.task('watch', function () {
  gulp.watch(['./app/**/*.html'], ['html']);
  gulp.watch(['./app/**/*.js'], ['js']);
  gulp.watch(['./app/**/*.css'], ['css']);
});

//Task do gulp rodar
gulp.task('default', ['connect', 'watch']);


