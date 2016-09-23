
Para usar o sistema deve-se criar o owner do banco com o seguinte nome:bancotrabalhosistema 
User: root
Senha: root



--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `pergunta` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `tipo_pergunta` int(11) DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Inserindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `senha`, `tipo`, `email`,`pergunta`, `tipo_pergunta`) VALUES
(1, 'teste', '1234', 1, 'teste@teste.com', 'palmeiras',1),
(2, 'tutor', '1234', 0, 'teste@teste.com', 'palmeiras',1);


-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

CREATE TABLE IF NOT EXISTS `estado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `sigla` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `estado`
--

INSERT INTO `estado` (`id`, `nome`, `sigla`) VALUES
('', 'São Paulo', 'SP');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE IF NOT EXISTS `cidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `estado_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAEE65724B36B3DE0` (`estado_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

INSERT INTO `cidade` (`id`, `nome`, `estado_id`) VALUES(1, 'Amparo', 1);


-- --------------------------------------------------------


-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE IF NOT EXISTS `endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `cidade_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK672D67C9246209E8` (`cidade_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


-- --------------------------------------------------------

--
-- Estrutura da tabela `indicador`
--

CREATE TABLE IF NOT EXISTS `indicador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `data_inatividade` date DEFAULT NULL,
  `ativo` int(1) NOT NULL ,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipoEstabelecimento`
--

CREATE TABLE IF NOT EXISTS `tipo_estabelecimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


-- --------------------------------------------------------

--
-- Estrutura da tabela `estabelecimento`
--

CREATE TABLE IF NOT EXISTS `estabelecimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `nome_fatasia` varchar(255) DEFAULT NULL,
  `cnpj` varchar(20) DEFAULT NULL,
  `inscricao_estadual` varchar(20) DEFAULT NULL,
  `endereco_id` int(11) NOT NULL,
 `data_inclusao` date DEFAULT NULL,
  `ativo` int(1) NOT NULL ,
  PRIMARY KEY (`id`),
  UNIQUE KEY `endereco_id` (`endereco_id`),
  KEY `FK334B85FAEE030DCB` (`endereco_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


