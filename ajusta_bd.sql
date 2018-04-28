/*Traduz categoria para compatibilizar com o projeto*/
update projetos set categoria = 'Eletrônicos (faça você mesmo)' where categoria = 'DIY Electronics';
update projetos set categoria = 'Exploração Espacial' where categoria = 'Space Exploration';
update projetos set categoria = 'Ferramentas de Fabricação' where categoria = 'Fabrication Tools';
update projetos set categoria = 'Equipamentos de Câmera' where categoria = 'Camera Equipment';
update projetos set categoria = 'Aplicativos' where categoria = 'Apps';
update projetos set categoria = 'Impressora 3D' where categoria = '3D Printing';
update projetos set categoria = 'Voos' where categoria = 'Flight';
update projetos set categoria = 'Música' where categoria = 'Sound';
update projetos set categoria = 'Espaço Maker' where categoria = 'Makerspaces';
update projetos set categoria = 'Robótica' where categoria = 'Robots';
update projetos set categoria = 'Tecnologia' where categoria = 'Technology';
update projetos set categoria = 'Usáveis' where categoria = 'Wearables';
update projetos set status = 'Sucesso' where status = 'successful';
update projetos set status = 'Cancelado' where status = 'canceled';
update projetos set status = 'Falhou' where status = 'failed';
update projetos set status = 'Suspenso' where status = 'suspended';
update projetos set status = 'Indefinido' where status = 'undefined';
update projetos set status = 'Em aberto' where status = 'live';
