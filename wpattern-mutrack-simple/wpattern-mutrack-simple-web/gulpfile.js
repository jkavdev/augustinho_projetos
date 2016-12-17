//Gulp como servidor 

// https://github.com/AveVlad/gulp-connect
// https://www.npmjs.com/package/gulp-inject

var gulp = require('gulp');
var connect = require('gulp-connect');
var inject = require('gulp-inject');

//Informamos que pagina que no qual tera os arquivos injetados
//Informamos os arquivos que serao injetados, no caso js e css

gulp.task('index', function () {
  var target = gulp.src('app/index.html');

  var source = gulp.src(['app/src/**/*.js', 'app/src/**/*.css'], {read: false});

  return target.pipe(inject(source, {relative: true})).pipe(gulp.dest('app/'));
});

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
gulp.task('default', ['connect', 'watch', 'index']);


