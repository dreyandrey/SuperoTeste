<?php
require_once __DIR__.'/vendor/autoload.php';

$app = new Silex\Application();
$app['debug'] = true;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

$app->register(new JDesrosiers\Silex\Provider\CorsServiceProvider(), [
    "cors.allowOrigin" => "*",
]);

$app->before(function (Request $request) {
    if (0 === strpos($request->headers->get('Content-Type'), 'application/json')) {
        $data = json_decode($request->getContent(), true);
        $request->request->replace(is_array($data) ? $data : array());
    }
});

$app->register(new Silex\Provider\DoctrineServiceProvider(), array(
    'db.options' => array(
        'driver'   => 'pdo_mysql',
		'host'      => '127.0.0.1',
		'dbname'    => 'test_supero',
		'user'      => 'root',
		'password'  => '',
		'charset'   => 'utf8',
    ),
));

$app->post('/tasklist', function(Request $request) use ($app) {
	
	$data = array('nm_product' => $request->request->get('nm_product'), 'ds_product' => $request->request->get('ds_product'), 'status' => $request->request->get('status'));
	$app['db']->insert('tasklist', $data);
	
	$last_insert_id = (int) $app['db']->lastInsertId('product_seq');
	
	$sql = "SELECT * FROM tasklist WHERE cd_product = ?";
    $post = $app['db']->fetchAssoc($sql, array((int) $last_insert_id));
	
	return json_encode($post, JSON_NUMERIC_CHECK);
});

$app->post('/tasklist/{id}', function(Request $request, $id) use ($app) {
	
	$sql = "UPDATE tasklist SET nm_product = ?, ds_product = ?, status = ?, dt_alteration = NOW() WHERE cd_product = ?";
	$app['db']->executeUpdate($sql, array($request->request->get('nm_product'), $request->request->get('ds_product'), $request->request->get('status'), (int) $id));
	
	return json_encode(array('cd_product' => $id), JSON_NUMERIC_CHECK);
});

$app->get('/tasklist', function () use ($app) {
	
	$sql = "SELECT * FROM tasklist";
    $post = $app['db']->fetchAll($sql);
	
	return json_encode($post, JSON_NUMERIC_CHECK);
});

$app->get('/tasklist/{id}', function ($id) use ($app) {
	$sql = "SELECT * FROM tasklist WHERE cd_product = ?";
    $post = $app['db']->fetchAll($sql, array((int) $id));
    return json_encode($post, JSON_NUMERIC_CHECK);
});

$app->delete('/tasklist/{id}', function ($id) use ($app) {
    $post = $app['db']->delete('tasklist', array('cd_product' => (int) $id));
    return json_encode(array('count' => $id));
});

$app->run();